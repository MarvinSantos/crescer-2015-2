$(document).ready(
    function () {
        $("#Cliente_Nome").autocomplete({
            source: "/Cliente/Autocomplete",
            select: function (event, ui) {
                $(this).val(ui.item.val);
            }
        });
    }
);