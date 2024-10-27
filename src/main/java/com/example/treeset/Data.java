package main.java.com.example.treeset;

import java.util.Comparator;
import java.util.Date;
import java.util.TreeSet;

public class Data implements Comparable<Data> {
    private int id;
    private Date time;

    public Data(int id, Date time) {
        this.id = id;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public Date getTime() {
        return time;
    }

    @Override
    public int compareTo(Data other) {
        if (this.id == other.id) {
            // 如果 ID 相同，则返回 0 表示相等
            return 0;
        } else {
            // 如果 ID 不同，则按 ID 排序
            return Integer.compare(this.id, other.id);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Data other = (Data) obj;
        return id == other.id && time.equals(other.time);
    }

    @Override
    public int hashCode() {
        return 31 * id + time.hashCode();
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", time=" + time +
                '}';
    }

    public static void main(String[] args) {
        Comparator<Data> comparator = (data1, data2) -> {
            if (data1.getId() == data2.getId()) {
                // 如果 ID 相同，则比较时间
                return data2.getTime().compareTo(data1.getTime()); // 注意这里的顺序是为了保留时间最大的数据
            } else {
                // 如果 ID 不同，则按 ID 排序
                return Integer.compare(data1.getId(), data2.getId());
            }
        };

        TreeSet<Data> dataSet = new TreeSet<>(comparator);

        // 添加一些数据
        dataSet.add(new Data(1, new Date(100L)));
        dataSet.add(new Data(1, new Date(200L)));
        dataSet.add(new Data(2, new Date(300L)));
        dataSet.add(new Data(1, new Date(150L)));

        // 输出结果
        for (Data data : dataSet) {
            System.out.println(data);
        }
    }
}