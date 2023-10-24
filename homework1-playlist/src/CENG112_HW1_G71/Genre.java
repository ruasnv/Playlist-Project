package CENG112_HW1_G71;

public class Genre<T> implements IBag<T> {
	
	private  T[] genreList;
	private int numberOfSongs;
    private int capacity =2000;
	

    
   
	@SuppressWarnings("unchecked")
	public Genre ()
    {
		T[] tempPlay = (T[]) new Object[100];
    	genreList = tempPlay;
		numberOfSongs = 0;
    }
	@Override
	public boolean add(T newItem) {
		//precondition: newItem != null && !this.isFull()
		//post-condition: Number of items are increased by1.
		if(!isFull()) {
			genreList[numberOfSongs] = newItem;
			numberOfSongs++;
			return true;
		}
		return false;
	}
	 public int getNumberOfSongs() {
			return numberOfSongs;
		}
	 
		public void setNumberOfSongs(int numberOfSongs) {
			this.numberOfSongs = numberOfSongs;
		}

	@Override
	public boolean isEmpty() {
		
		return numberOfSongs == 0;
	}

	@Override
	public boolean isFull() {
		return capacity == 0;
	}

	@Override
	public T removeByIndex(int index) {
		if(!isEmpty()) {
			T temp = genreList[index];
			genreList[index] = genreList[numberOfSongs-1];
			genreList[numberOfSongs-1] = null;
			
			numberOfSongs--;
			return temp;
		}
		return null;
	}

	@Override
	public T remove() {
		if(!isEmpty()) {
			T temp = genreList[numberOfSongs-1];
			genreList[numberOfSongs-1] = null;
			return temp;
		}
		return null;
	}

	@Override
	public int getItemCount() {
		return numberOfSongs;
	}

	@Override
	public int getIndexOf(T item) {
		if(!isEmpty()) {
			for(int i = 0; i < numberOfSongs; i++) {
				if(genreList[i].equals(item))
					return i;
			}
		}
		return -1;
	}

	@Override
	public boolean contains(T item) {
		boolean result = false;
		if(!isEmpty()) {
			if(getIndexOf(item) >= 0)
				result = true;
		}
		return result;
	}

	@Override
	public void displayItems() {
		if(!isEmpty()) {
			for(int i = 0; i < numberOfSongs; i++) {
				System.out.print("["+(i+1)+"]");
				System.out.print(genreList[i]);
			}
			System.out.println("");
		}
	}

	@Override
	public void dump() {
		while(!isEmpty()) {
			remove();
		}
	}

	@Override
	public boolean transferTo(IBag<T> targetBag, T item) {
		if(!isEmpty()) {
			targetBag.add(item);
		}
		return true;
	}
	/**For Security**/
	

		
		/*Getters*/
		@SuppressWarnings("unchecked")
		public T[] getArray() {
				T[] newArray = (T[]) new Object[numberOfSongs];
				for(int i = 0; i < numberOfSongs; i++) {
					newArray[i] = removeByIndex(i);}
				return newArray;
		}

        public Song maxPopularity() {
			Genre<Song> chars = new Genre<>(); ;
			int j = 0;
			Song a = chars.getArray()[0];
			int max = a.getTrack_popularity();
		    for (int ktr = 0; ktr < chars.numberOfSongs; ktr++) {
		    	Song x = chars.getArray()[ktr];
		        if( x.getTrack_popularity() > max) {
		            max = x.getTrack_popularity();
		            j = ktr;
		        }
		    }
		    return chars.getArray()[j];}

	public T[] getGenreList() {
		
		return genreList;
	}

	public void setGenreList(T[] genreList) {
		this.genreList = genreList;
	}

}
