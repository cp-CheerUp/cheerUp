$(function() {
    var category = $('input[name="category"]:checked').val();
    if(category != '02'){
        $('#codingDiffSector').hide();
    }else{
        $('#codingDiffSector').show();
    }
});