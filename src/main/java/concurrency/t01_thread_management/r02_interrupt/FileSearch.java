package concurrency.t01_thread_management.r02_interrupt;

import java.io.File;

public class FileSearch implements Runnable {
    private String initPath;
    private String fileName;

    public FileSearch(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        File file = new File(initPath);
        if (file.isDirectory()) {
            try {
                directoryProcess(file);
            } catch (InterruptedException ex) {
                System.out.printf("%s: The search has been interrupted\n", Thread.currentThread().getName());
            }
        }
    }

    private void directoryProcess(File path) throws InterruptedException {
        File[] list = path.listFiles();
        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].isDirectory()) {
                    directoryProcess(list[i]);
                } else {
                    fileProcess(list[i]);
                }
            }
        }
        if (Thread.interrupted()) {
            System.out.printf("Interrupted when processing: %s\n", path);
            throw new InterruptedException();
        }
    }

    private void fileProcess(File file) throws InterruptedException {
        if (file.getName().equals(fileName)) {
            System.out.printf("%s : %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
        }
        if (Thread.interrupted()) {
            System.out.printf("Interrupted when processing: %s\n", file);
            throw new InterruptedException();
        }
    }
}
