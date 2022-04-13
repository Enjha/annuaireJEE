function showStack() {
    var base = ($('<a href=".">')[0].href);
    $.ajax({
        type : 'GET',
        url : (base + "calculator/show"),
        data : '200',
        timeout : 3000,
        success : function(data) {
            $('#numbers').hide();
            $('#numbers').html("Stack: ");
            jQuery.each(data, function(i, val) {
                $("#numbers").append(" - ");
                $("#numbers").append(document.createTextNode(val));
            });
            $('#numbers').show();
        }
    });
}

function show() {
    showStack();
    $('#message').html("");
}

function add() {
    var base = ($('<a href=".">')[0].href);
    $.ajax({
        type : 'GET',
        url : (base + "calculator/add"),
        timeout : 3000,
        error : function() {
            $('#message').html('Addition impossible');
            showStack();
        },
        success : function(data) {
            $('#message').html('Addition réalisée');
            showStack();
        }
    });
}
function sub() {
    var base = ($('<a href=".">')[0].href);
    $.ajax({
        type : 'GET',
        url : (base + "calculator/sub"),
        timeout : 3000,
        error : function() {
            $('#message').html('Soustraction impossible');
            showStack();
        },
        success : function(data) {
            $('#message').html('Soustraction réalisée');
            showStack();
        }
    });
}
function put() {
    var base = ($('<a href=".">')[0].href);
    var value = ($('#input').val());
    $.ajax({
        type : 'POST',
        url : (base + "calculator/put"),
        data : value,
        timeout : 3000,
        dataType : "json",
        contentType : "application/json",
        success : function(data) {
            showStack();
            $('#input').html("");
        },
        error : function() {
            showStack();
            $('#input').html("");
        }
    });
}