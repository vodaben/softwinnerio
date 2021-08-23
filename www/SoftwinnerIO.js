var exec = require('cordova/exec');


var SoftwinnerIO = {

    echo: function(data) {
        exec(null, null, "SoftwinnerIO", "echo", [data]);
    },
    adjustRed: function(level) {
        exec(null, null, "SoftwinnerIO", "adjustRed", [level]);
    },
    adjustGreen: function(level) {
        exec(null, null, "SoftwinnerIO", "adjustGreen", [level]);
    },
    adjustYellow: function(level) {
        exec(null, null, "SoftwinnerIO", "adjustYellow", [level]);
    },
    closeLed: function() {
        exec(null, null, "SoftwinnerIO", "closeLed", []);
    },
    setMulSel: function(pinName, pinNumber, flag) {
        exec(null, null, "SoftwinnerIO", "setMulSel", [pinName, pinNumber, flag]);
    },
    writeGpio: function(pinName, pinNumber, flag) {
        exec(null, null, "SoftwinnerIO", "writeGpio", [pinName, pinNumber, flag]);
    },
    readGpio: function(pinName, pinNumber, success) {
        exec(success, null, "SoftwinnerIO", "readGpio", [pinName, pinNumber]);
    }
};

module.exports = SoftwinnerIO;
