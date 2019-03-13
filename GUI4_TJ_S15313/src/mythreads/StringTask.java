package mythreads;

public class StringTask implements Runnable {

	private volatile TaskState state;
	private int replicationCount;
	private String data;
	private String result = "";
	private Thread thread;

	public StringTask(String data, int replicationCount) {
		this.state = TaskState.CREATED;
		this.data = data;
		this.replicationCount = replicationCount;
		this.thread = new Thread(this);
	}

	/**
	 * zwracającą wynik konkatenacji
	 * 
	 * @return
	 */
	public String getResult() {
		return result;
	}

	/**
	 * zwracającą stan zadania
	 * 
	 * @return
	 */
	public TaskState getState() {
		return state;
	}
	
	private void setState(TaskState newState){
		//System.out.println("Changing state: " + state + " -> " + newState);
		this.state = newState;
	}

	/**
	 * uruchamiającą zadanie w odrębnym watku
	 */
	public synchronized void start() {
		setState(TaskState.RUNNING);
		thread.start();
	}

	/**
	 * przerywającą wykonanie kodzu zadania i działanie watku
	 */
	public synchronized void abort() {
		setState(TaskState.ABORTED);
		thread.interrupt();
	}

	/**
	 * zwracająca true, jeśli wykonanie zadania się zakończyło normalnie lub
	 	przez przerwanie, false w przeciwnym razie
	 */
	public synchronized boolean isDone() {
		return state == TaskState.ABORTED || state == TaskState.READY;
	}


	@Override
	public void run() {
		for (int i = 0; i < replicationCount; i++) {
			if (thread.isInterrupted()) {
				return;
			}
			result = result + data;
		}
		setState(TaskState.READY);
	}
}
