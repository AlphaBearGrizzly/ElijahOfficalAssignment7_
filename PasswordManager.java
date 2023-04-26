package assn07;
import java.util.*;

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
            } else {
                Account curNode = _passwords[hashNum];
                while (_passwords[hashNum].getNext() != null){
                    curNode = curNode.getNext();
                }
                Account newNode = null;
                newNode.setPassword(value);
                newNode.setWebsite(key);
                curNode.setNext(newNode);
                //this adds that chain to handle collisions
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
        int returnValue = 0;
        // number of elements in the structure
        for (int i = 0; i <= _passwords.length - 1; i++) {
            if (this._passwords[i] != null) {
                returnValue += 1;
            }
        }
        return returnValue;
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
                    _passwords[i] = null;
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

        /**
         * Returns a list the website names
         * that have a password matching the parameter
         *
         * @return A List containing the keys of accounts whose password
         * match the parameter
         */
        List<K> keySet = new ArrayList<>();

        for (int i = 0; i <_passwords.length; i++){
            if (this._passwords[i] != null){
                if(_passwords[i].getPassword().equals(value)){
                    //Account[] container = new Account[5];
                    //container[1].setPassword(_passwords[i].getWebsite());
                    // remove the thing
                    keySet.add((K)_passwords[i].getWebsite());

                }
            }

        }
        return keySet;
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
