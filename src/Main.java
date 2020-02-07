import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {




    public static void main(String[] args) {
        MyPanel p = new MyPanel();//实例一个对象
        Thread panelThread = new Thread(p);
        JFrame frame = new JFrame();
        frame.add(p);
        frame.setSize(1000, 800);//设置窗口大小
        frame.setLocationRelativeTo(null);//屏幕中央显示
        frame.setVisible(true);//窗口是否可见
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭JFrame时运行System.exit(0)
        panelThread.start();

        List<Person> people = PersonPool.getInstance().getPersonList();
        for(int i=0;i<Constants.ORIGINAL_COUNT;i++){
            int index = new Random().nextInt(people.size()-1);
            Person person = people.get(index);

            while (person.isInfected()){
                index = new Random().nextInt(people.size()-1);
                person = people.get(index);
            }
            person.beInfected();

        }


    }
}
