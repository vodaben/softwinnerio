# Cordova Softwinner LED/GPIO Plugin

# how to use
1. add the plugins to your project 'ionic cordova plugins add https://github.com/vodaben/softwinnerio.git'
2. add 'declare let cordova: any;' to the component
3. call 'cordova.plugins.SoftwinnerIO.<fn>()'

# API

#### adjustRed, adjustGreen, adjustYellow

Set LED to R/G/Y. With brightness level 1-4

param:
- level: (1 - 4)

example:
```
cordova.plugins.SerialPortPlugin.adjustRed(1);
```

#### closeLed

Close LED

example:
```
cordova.plugins.SerialPortPlugin.closeLed();

```
