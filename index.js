import { NativeModules, Platform } from 'react-native';
const invariant = require('invariant');
// const RNCookieManagerIOS = NativeModules.RNCookieManagerIOS;
const TenjinRnAndroid = NativeModules.RNCookieManagerAndroid;

let TenjinRn;

if (Platform.OS === 'ios') {
  console.log('ios currently not supported')
  // invariant(
  //   RNCookieManagerIOS,
  //   '@react-native-community/cookies: Add RNCookieManagerIOS.h and RNCookieManagerIOS.m to your Xcode project',
  // );
  // CookieManager = RNCookieManagerIOS;
} else if (Platform.OS === 'android') {
  invariant(
    TenjinRnAndroid,
    'tenjin-rn: Import libraries to android "react-native link tenjin-rn"',
  );
  TenjinRn = TenjinRnAndroid;
} else {
  invariant(
    TenjinRn,
    'tenjin-rn: Invalid platform. This library only supports Android and iOS.',
  );
}

const functions = ['setFromResponse', 'getFromResponse'];

module.exports = {
  set: (url, cookie) => TenjinRn.set(url, cookie),
};

for (var i = 0; i < functions.length; i++) {
  module.exports[functions[i]] = TenjinRn[functions[i]];
}
