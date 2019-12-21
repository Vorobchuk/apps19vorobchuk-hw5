package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;

import java.util.ArrayList;
import java.util.Collections;

public class AsIntStream implements IntStream {
    private ArrayList<Integer> array;

    private AsIntStream(ArrayList<Integer> values) {
       this.array= values;
    }

    public static IntStream of(int... values) {
        ArrayList<Integer> val = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
           val.add(values[i]);
        }
         return new AsIntStream(val);
    }
    private void Check(){
        if (array.size()==0){
            throw new IllegalArgumentException();
        }
    }
    @Override
    public Double average() {
        Check();
        return ((double) this.sum())/ this.count();
    }

    @Override
    public Integer max() {
       Check();
       return Collections.max(array);
    }

    @Override
    public Integer min() {
        Check();
        return Collections.min(array);
    }

    @Override
    public long count() {
        return array.size();
    }

    @Override
    public Integer sum() { 
        Check();
        int res = 0;
        for (int el: array) {
            res+= el;
        }
        return res;
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i: array){
            if(predicate.test(i)){
                res.add(i);
            }
        }
        return new AsIntStream(res);
    }

    @Override
    public void forEach(IntConsumer action) {
        for (int i : array) {
            action.accept(i);
        }
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i: array){
            int elem = mapper.apply(i);
            res.add(elem);
        }
        return new AsIntStream(res);
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i: array){
            IntStream arr = func.applyAsIntStream(i);
            for(int el: arr.toArray()){
                res.add(el);
            }
        }
        return new AsIntStream(res);
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        int res = identity;
        for (int el :array) {
            res = op.apply(res, el);
        }
        return res;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            result[i] = array.get(i);
        }
        return result;
    }

}
