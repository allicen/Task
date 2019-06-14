import javax.sound.sampled.*;
import java.util.*;
import java.io.*;
class Sound implements Runnable  {
    private SourceDataLine line = null;
    private AudioInputStream ais = null;
    private byte[] b = new byte[2048];
    synchronized public void run(){
        playSound();
        stopSound();
    }
    private void playSound(){
        try{
            File f = new File("E:\\JAVA\\IDEA\\5lab-sound\\sample.wav");
            ais = AudioSystem.getAudioInputStream(f);
            AudioFormat af = ais.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, af);
            if (!AudioSystem.isLineSupported(info)){
                System.err.println("Линия не поддерживается");
                System.exit(0);
            }
            line = (SourceDataLine)AudioSystem.getLine(info);
            line.open(af);
            line.start();
            int num = 0;
            while(( num = ais.read(b)) != -1)
                line.write(b, 0, num);
            line.drain();
            ais.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    private void stopSound(){
        line.stop();
        line.close();
    }
    private void stop(){
        stopSound();
    }
    public static void main(String[] args){
        System.out.println("На какой секунде вы хотите остановить проигрывание музыки?");
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        int sec = time * 1000;
        Sound musicPlay = new Sound();
        try{
            new Thread(musicPlay).start();
            Thread.sleep(sec);
            musicPlay.stop();
        }catch(InterruptedException ie){
            System.err.println(ie);
        }
        System.out.println("Готово! Проигрывание остановлено на "+time+" секунде.");
    }
}