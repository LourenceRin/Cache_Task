package model;

import java.util.Objects;

public class BaseNode <K, V>{
    private final K key;

    private final V value;

    public BaseNode(final K key, final V value){
        this.key = key;
        this.value = value;
    }

    private K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final BaseNode<?, ?> baseNode = (BaseNode<?, ?>) object;
        return Objects.equals(getKey(), baseNode.getKey()) &&
                Objects.equals(getValue(), baseNode.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getValue());
    }
}
