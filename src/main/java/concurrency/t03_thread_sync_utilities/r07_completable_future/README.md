# Completing and Linking Tasks Asynchronously

`CompletableFuture` implements the `Future` object and the `CompletionStage` 
interface. As a `Future` object, it will return a result sometime in the 
future. As a `CompletionStage` object, it can execute more asynchronous 
tasks after the completion of one or more `CompletableFuture` object.

`CompletableFuture` is very flexible and powerful.