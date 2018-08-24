function queryData() {
    var obj = $.ajax({
        url:"./querydata",
        type:"GET",
        async:false,
        dataType:"json",
        data:{}
    });
    return JSON.parse(obj.responseText);
}