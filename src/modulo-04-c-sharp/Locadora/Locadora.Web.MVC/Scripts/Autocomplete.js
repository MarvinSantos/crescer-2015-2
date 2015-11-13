$(document).ready(
    function () {
        $("#Cliente_Nome").autocomplete({
            source: "/Jogo/Autocomplete",
            select: function (event, ui) {
                $(this).val(ui.item.val);
            }
        });
    }
);