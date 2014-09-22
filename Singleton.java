//package binglu.me

/* Three ways to implement thread safe singleton pattern

/*
 * using synchronization (lock) to achieve thread safe
 * performance is a problem
 */
public class Singleton{
	private static Singleton instance = null;

	private Singleton(){

	}

	public synchronized static Singleton getInstance(){
		if(instance == null)
			instance = new Singleton();

		return instance;
	}
}

/*
 * double check idiom, works after java 1.5 with volatile keyword
 * performance is better than above
 */
public class Singleton{
	private volatile static Singleton instance = null;	//without volatile keyword, it's not threadsafe

	private Singleton(){

	}

	public static Singleton getInstance(){
		if(instance == null){	//first check
			synchronized(this){
				if(instance == null){	//second check
					instance = new Singleton();
				}
			}
		}

		return instance;
	}
}

/*
 * initialization on demand holder idiom
 * performance is best
 */
public class Singleton {
    private Singleton(){

    }
 
 	//inner class to hold instance
    private static class LazyHolder{
        private static final Singleton instance = new Singleton();
    }
 
    public static Singleton getInstance(){
        return LazyHolder.instance;
    }
}