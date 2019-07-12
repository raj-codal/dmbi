package dmbi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Raj Dhanani
 */

public class Bin {
    List data;
    int size;
    public Bin(List data,int size){
        this.data = data;
        this.size = size;
    }
    List smoothingByMean(){
        List temp = new ArrayList();
        int mean=0;
        int r = data.size() % size;
        for (int i = 0; i < data.size() - r; i+=size) {
            mean = 0;
            for (int j = 0; j < size; j++) {
                mean += (int) data.get(i+j);
            }
            mean /= size;
            for (int j = 0; j < size; j++) {
                temp.add(mean);
            }
        }
        mean = 0;
        for (int i = data.size() - r; i < data.size(); i++) {
            mean += (int)data.get(i);
        }
        if(r != 0)
            mean /= r;
        for (int i = data.size() - r; i < data.size(); i++) {
            temp.add(mean);
        }
        return temp;
    }
    
    List smoothingByBoundary(){
        List temp = new ArrayList();
        int min,max;
        int r = data.size() % size;
        for (int i = 0; i < data.size() - r; i+=size) {
            List t1 = data.subList(i,i + size);
            max = (int) Collections.max(t1);
            min = (int) Collections.min(t1);
            for(Object x : t1){
                if(max - (int)x < (int)x - min){
                    temp.add(max);
                }
                else{
                    temp.add(min);
                }
            }
        }
        if(r != 0){
            List t1 = data.subList(data.size() - r,data.size());
            max = (int) Collections.max(t1);
            min = (int) Collections.min(t1);
            for(Object x : t1){
                if(max - (int)x < (int)x - min){
                    temp.add(max);
                }
                else{
                    temp.add(min);
                }
            }
        }
        return temp;
    }
    
    List smoothingByMedian(){
        List temp = new ArrayList();
        int median;
        int r = data.size() % size;
        for (int i = 0; i < data.size() - r; i+=size) {
            List t1 = data.subList(i,i + size);
            Collections.sort(t1);
            if(t1.size() % 2 == 0){
                median = (int) ( ( (int)t1.get(t1.size()/2 - 1) + (int)t1.get(t1.size()/2) ) / 2 );
            }
            else{
                median = (int) t1.get(t1.size()/2);
            }
            for (int j = 0; j < size; j++) {
                temp.add(median);
            }
        }
        if(r != 0){
            List t1 = data.subList(data.size() - r,data.size());
            Collections.sort(t1);
            if(t1.size() % 2 == 0){
                median = (int) ( ( (int)t1.get(t1.size()/2 - 1) + (int)t1.get(t1.size()/2) ) / 2 );
            }
            else{
                median = (int) t1.get(t1.size()/2);
            }
            for (int j = 0; j < r; j++) {
                temp.add(median);
            }
        }
        return temp;
    }
}
