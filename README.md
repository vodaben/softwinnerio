# Cordova Softwinner LED/GPIO Plugin

# How to use
1. add the plugins to your project
`ionic cordova plugins add https://github.com/vodaben/softwinnerio.git`
2. add `declare let cordova: any;` to your component
3. call functions in `cordova.plugins.SoftwinnerIO`

# LED API

#### adjustRed, adjustGreen, adjustYellow

Set LED to R/G/Y. With brightness level 1-4

param:
- level: (1 - 4)

example:
```js
cordova.plugins.SoftwinnerIO.adjustRed(1);
```

#### closeLed

Close LED

example:
```js
cordova.plugins.SoftwinnerIO.closeLed();

```

# GPIO API

#### setMulSel

Set GPIO direction

params:
- pinName
- pinNumber
- flag: (0: Input, 1: Output)

example:
```js
cordova.plugins.SoftwinnerIO.setMulSel('E', 0, 1);

```

#### writeGpio

Write to GPIO

params:
- pinName
- pinNumber
- flag: (0: Low, 1: High)

example:
```js
cordova.plugins.SoftwinnerIO.writeGpio('E', 0, 1);

```

#### readGpio

Write to GPIO

params:
- pinName
- pinNumber
- callback: (result: int) => {}

callback:
- result: (0: Low, 1: High)

example:
```js
cordova.plugins.SoftwinnerIO.readGpio('E', 0, (result) => {
  // ...
});

```


