package concurrency.t04_thread_executors.r03_first_result_among_many_tasks;

import java.util.concurrent.Callable;

public class ValidatorTask implements Callable<String> {
  private final String user;
  private final String password;
  private UserValidator validator;

  public ValidatorTask(UserValidator validator, String user, String password) {
    this.user = user;
    this.password = password;
    this.validator = validator;
  }

  @Override
  public String call() throws Exception {
    if (!validator.validate(user, password)) {
      System.out.printf("%s: The user has not been found\n",
          validator.getName());
      throw new Exception("Error validating user");
    }
    System.out.printf("%s: The user has been found\n", validator.getName());

    return validator.getName();
  }
}
