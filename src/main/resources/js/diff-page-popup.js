(function ($) {
    $(function () {
        AJS.$('#diff-page').unbind('click');
        AJS.$('#diff-page').bind("click", function (e) {
            e.preventDefault();
            var link = AJS.$(this);
            AJS.$.get(link.attr('href'), function (response) {
                AJS.$('.aui-page-panel').after(response);
                AJS.dialog2("#diff-page-popup").show();
                Confluence.Binder.autocompletePage(AJS.$("#diff-page-popup-binder"));
            });
            return false;
        });
    });
})(AJS.$);