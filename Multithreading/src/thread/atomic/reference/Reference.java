package thread.atomic.reference;

import java.util.concurrent.atomic.AtomicReference;

public class Reference {
    public static void main(String[] args) {
        String hugo="hugo";
        String baltazar="baltazar";
        AtomicReference<String> atomicReference =new AtomicReference<>(hugo);

       // atomicReference.set("Unexpected name");
        if(atomicReference.compareAndSet(hugo,baltazar)){
            System.out.println("New Value is "+atomicReference.get());
        }else{
            System.out.println("Nothing Changed");
        }
    }
}
