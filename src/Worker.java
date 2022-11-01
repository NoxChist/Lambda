public class Worker {
    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback) {
        this.callback = callback;
    }
    public Worker(OnTaskErrorListener errorCallback) {
        this.errorCallback = errorCallback;
    }
    public void start(int failed) {
        for(int i=0;i<100;i++){
            if(i!=failed) {
                callback.onDone("Task " + i + " is done");
            }
            else {
                if(errorCallback==null){
                    errorCallback = System.out::println;
                }
                errorCallback.onError("Task " + i + " is failed");
            }
        }
    }

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }
    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String result);
    }

}
