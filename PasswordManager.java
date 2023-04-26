package assn07;
import java.util.Scanner;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class PasswordManager<K,V> implements Map<K,V> {
    private static final String MASTER_PASSWORD = "password123";
    private Account[] _passwords;

    public PasswordManager() {
        _passwords = new Account[50];
    }


    // TODO: put
    @Override
    public void put(K key, V value) {

        /**
         * Creates an Account object using the key value pair,
         * and inserts the object at the appropriate index
         * based on the hash of they key. If the key already
         * exists in map, update its value.
         * @param key: the website name
         * @param value: the password
         */
        Account[] putContainer;
        // if the key already exists in the map, update the value
        boolean valueExists = false;
        for (int i = 0; i <_passwords.length; i++){
            if (this._passwords[i] != null){
                if(_passwords[i].getWebsite().equals(key)){
                    _passwords[i].setPassword(value);
                    valueExists = true;
                }
            }
        }
        if (valueExists == false){
            int hashNum = Math.abs(key.hashCode() % _passwords.length);
            if (_passwords[hashNum] == null) {
                _passwords[hashNum].setPassword(value);
                _passwords[hashNum].setWebsite(key);
            }
        }
    }

    // TODO: get
    @Override
    public V get(K key) {
        int getIndex = key.hashCode();
        if (_passwords[getIndex] != null){
            return (V) _passwords[getIndex].getPassword();
        } else {
            return null;
        }
    }

    // TODO: size
    @Override
    public int size() {
        // number of elements in the structure
        return _passa
    }

    // TODO: keySet
    @Override
    public Set<K> keySet() {

        Set<K> setKeys = new HashSet<K>();
        for(int i = 0; i <= _passwords.length; i++){
            if (this._passwords[i] != null){
                setKeys.add((K) _passwords[i].getWebsite());
            }
        }
        return setKeys;
    }

    // TODO: remove
    @Override
    public V remove(K key) {

        for (int i = 0; i <_passwords.length; i++){
            if (this._passwords[i] != null){
                if(_passwords[i].getWebsite().equals(key)){
                    //Account[] container = new Account[5];
                    //container[1].setPassword(_passwords[i].getWebsite());
                    // remove the thing
                    V value = (V) _passwords[i].getPassword(); //this casts it
                    _passwords[i-1].setNext(_passwords[i+1]);
                    return value;
                }
            }
// key = password!
// value = website!
            //otherwise do this
        }
        return null;
    }

    // TODO: checkDuplicate
    @Override
    public List<K> checkDuplicate(V value) {



        return null;
    }

    // TODO: checkMasterPassword
    @Override
    public boolean checkMasterPassword(String enteredPassword) {
        if (enteredPassword.equals(MASTER_PASSWORD)){
            return true;
        }
        return false;
    }

    /*
    Generates random password of input length
     */
    @Override
    public String generateRandomPassword(int length) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = length;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    /*
    Used for testing, do not change
     */
    public Account[] getPasswords() {
        return _passwords;
    }


}
