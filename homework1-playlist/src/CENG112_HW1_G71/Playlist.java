package CENG112_HW1_G71;


public class Playlist<T> implements IBag<T>{
         
	    private final T[] playlist;
        private int playlistType;
		private boolean secure = false;

       private final int capacity = 2000;
		private int duration;
		private int numberOfSongs;
		
		/**Constructor**/
		@SuppressWarnings("unchecked")
		public Playlist(int playlistType,int duration) {
			this.setPlaylistType(playlistType);
			this.setDuration(duration);
			T[] tempList = (T[]) new Object[capacity];
			playlist = tempList;
			setNumberOfSongs(0);}

		public boolean add(T newItem) {
			//precondition: newItem != null && !this.isFull()
			//post-condition: Number of items are increased by1.
			checkSecurity();
			if(!isFull()) {
				playlist[numberOfSongs] = newItem;
				numberOfSongs++;
				return true;
			}
			return false;
		}

		@Override
		public boolean isEmpty() {
			
			return numberOfSongs == 0;
		}

		@Override
		public boolean isFull() {
			checkSecurity();
			return capacity == 0;
		}

		@Override
		public T removeByIndex(int index) {
			checkSecurity();
			if(!isEmpty()) {
				T temp = playlist[index];
				playlist[index] = playlist[numberOfSongs-1];
				playlist[numberOfSongs-1] = null;
				
				numberOfSongs--;
				return temp;
			}
			return null;
		}

		@Override
		public T remove() {
			checkSecurity();
			if(!isEmpty()) {
				T temp = playlist[numberOfSongs-1];
				playlist[numberOfSongs-1] = null;
				return temp;
			}
			return null;
		}

		@Override
		public int getItemCount() {
			checkSecurity();
			return numberOfSongs;
		}

		@Override
		public int getIndexOf(T item) {
			checkSecurity();
			if(!isEmpty()) {
				for(int i = 0; i < numberOfSongs; i++) {
					if(playlist[i].equals(item))
						return i;
				}
			}
			return -1;
		}

		@Override
		public boolean contains(T item) {
			checkSecurity();
			boolean result = false;
			if(!isEmpty()) {
				if(getIndexOf(item) >= 0)
					result = true;
			}
			return result;
		}

		@Override
		public void displayItems() {
			checkSecurity();
			if(!isEmpty()) {
				for(int i = 0; i < numberOfSongs; i++) {
					System.out.print("["+(i+1)+"]");
					System.out.print(playlist[i]);
				}
				System.out.println("");
			}
		}

		@Override
		public void dump() {
			checkSecurity();
			while(!isEmpty()) {
				remove();
			}
		}

		@Override
		public boolean transferTo(IBag<T> targetBag, T item) {
			checkSecurity();
			if(!isEmpty()) {
				targetBag.add(item);
			}
			return true;
		}
		/**For Security**/
		private void checkSecurity() {
			if(!secure) {
				throw new SecurityException("ShoppingBasket object is not initialized appropriately.");
			}
		}

		public int getPlaylistType() {
			return playlistType;
		}

		public void setPlaylistType(int playlistType) {
			this.playlistType = playlistType;
		}

		public int getDuration() {
			return duration;
		}

		public void setDuration(int duration) {
			this.duration = duration;
		}

		public int getNumberOfSongs() {
			return numberOfSongs;
		}

		public void setNumberOfSongs(int numberOfSongs) {
			this.numberOfSongs = numberOfSongs;
		}

		public T[] getPlaylist() {
			return playlist;
		}
		@SuppressWarnings("unchecked")
		public T[] getPlaylistArray() {
				T[] newArray = (T[]) new Object[numberOfSongs];
				for(int i = 0; i < numberOfSongs; i++) {
					newArray[i] = removeByIndex(i);}
				return newArray;
		}

//		   

	}

	
	
	
	
	