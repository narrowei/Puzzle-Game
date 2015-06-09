package Demo4;


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
public class Score {
	public void writeScore(int[] a) throws IOException{
		PrintWriter pw = new PrintWriter(new FileOutputStream("score.txt")); 
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		for(int i=0;i<a.length;i++){
		pw.println(a[i]);
		}
		pw.close();
	}
	public int[] readScore() throws IOException{
		FileReader fr=new FileReader("score.txt");
		BufferedReader br = new BufferedReader(fr);
		String n;
		int i=0;
		int[] number = new int[5];
		while((n=br.readLine()) != null){
			number[i]=Integer.parseInt(n);
			i++;
		}
		return number;
	}
	public void clearScore() throws IOException{
		int a[]={0,0,0,0,0};
		writeScore(a);
	}
	public void addNewScore(int score) throws IOException{
		int a[]=new int[5];
			a=readScore();
		int temp[]=new int[6];
		for(int i=0;i<temp.length;i++){
			if(i<5)
			temp[i]=a[i];
			else
			temp[i]=score;
		}
		Arrays.sort(temp);
		System.out.println(Arrays.toString(temp));
		for(int i=0;i<a.length;i++){
			a[i]=temp[(i+1)];
		}
		System.out.println(Arrays.toString(a));
		writeScore(a);
	}
	public int getScore(int i) throws IOException{
		int a[]=readScore();
		return a[i];
		
	}
}
