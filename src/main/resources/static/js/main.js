/**
 * Created by vmuser016 on 2017/3/24.
 */
require.config({
    paths : {
        "jquery" : "jquery-3.2.0",
        "underscore" : "underscore",
        "vue" : "vue",
        "easyui" : "jquery-easyui-1.5.1/jquery.easyui.min",
        "jquery.dialog" : "jquery-easyui-1.5.1/plugins/jquery.dialog"
    },
    shims : {
        "underscore" : {
            exports : "_"
        },
        "easyui" : {
            deps : ["jquery"]
        },
        "jquery.dialog" : {
            deps : ["easyui"]
        }
    }
});

require(["jquery", "underscore","jquery.dialog"], function ($) {
    $("#dialog-confirm").dialog();
})