import { NativeModules } from 'react-native';
const SharedPreference = NativeModules.SharedPreference;

async function showAll() {
  SharedPreference.showAll(
    (err) => console.error(err),
    (msg) => console.log('Message from Java =>', msg),
  );
}

async function set(key, value) {
  SharedPreference.set(
    key,
    value,
    (err) => console.error(err),
    (msg) => console.log('Message from Java =>', msg),
  );
}

async function get(key) {
  SharedPreference.get(
    key,
    (err) => console.error(err),
    (msg) => console.log('Message from Java =>', msg),
  );
}

export { showAll, set, get };