public class Hello {
	public static void main(String[] args) {
		String txt = "781059910132116111321091011011163212111111746";
		String keys = "23232332333323332";
		int path = 0;
		for(int i=0; i<keys.length(); i++) {
			int key = keys.charAt(i)-'0';
			System.out.print((char)Integer.parseInt(txt.substring(path, path+key)));
			path += key;
		}
	}
}