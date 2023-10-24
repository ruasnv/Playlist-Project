package CENG112_HW1_G71;

public class SongBag<T> {
	
		private final T[] songsArray;
		
		public SongBag(T[] songs) {
			songsArray = songs;
		}
		public T[] getArray() {
			return songsArray;
		}
		
	}


