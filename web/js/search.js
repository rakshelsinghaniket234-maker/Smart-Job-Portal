function searchJobs() {

    var input = document.getElementById("searchInput");

    var filter = input.value.toLowerCase();

    var table = document.getElementById("jobsTable");

    var rows = table.getElementsByTagName("tbody")[0]
                    .getElementsByTagName("tr");

    for (var i = 0; i < rows.length; i++) {

        var rowText = rows[i].innerText.toLowerCase();

        if (rowText.indexOf(filter) > -1) {
            rows[i].style.display = "";
        } else {
            rows[i].style.display = "none";
        }
    }
}