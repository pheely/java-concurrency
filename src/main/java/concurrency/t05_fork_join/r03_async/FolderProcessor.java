package concurrency.t05_fork_join.r03_async;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountedCompleter;

public class FolderProcessor extends CountedCompleter<List<String>> {
    private String path;
    private String extension;
    private List<FolderProcessor> tasks;
    private List<String> resultList;

    public List<String> getResultList() {
        return resultList;
    }

    protected FolderProcessor(CountedCompleter<?> completer, String path, String extension) {
        super(completer);
        this.path = path;
        this.extension = extension;
    }
    public FolderProcessor(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    @Override
    public void compute() {
        resultList = new ArrayList<>();
        tasks = new ArrayList<>();
        File file = new File(path);
        File[] contents = file.listFiles();
        if (contents != null) {
            for (int i = 0; i < contents.length; i++) {
                if (contents[i].isDirectory()) {
                    FolderProcessor task = new FolderProcessor(this, contents[i].getAbsolutePath(), extension);
                    task.fork();
                    addToPendingCount(1);
                    tasks.add(task);
                }else {
                    if (checkFile(contents[i].getName())) {
                        resultList.add(contents[i].getAbsolutePath());
                    }
                }
                if (tasks.size() > 50) {
                    System.out.printf("%s: %d tasks ran.\n", file.getAbsolutePath(), tasks.size());
                }
            }
            tryComplete();
        }
    }
    @Override
    public void onCompletion(CountedCompleter<?> completer) {
        for (FolderProcessor childTask : tasks) {
            resultList.addAll(childTask.getResultList());
        }
    }

    private boolean checkFile(String name) {
        return name.endsWith(extension);
    }
}
