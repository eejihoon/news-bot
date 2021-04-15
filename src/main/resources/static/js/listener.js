const listener = {
    init: () => {
        document.querySelector("#btn-subscribe").addEventListener("click", (e) => {
                e.preventDefault();
                const email = document.querySelector("#email");
                const xmlHttpRequest = new XMLHttpRequest();
                xmlHttpRequest.open('POST', '/api/subscribe/'+email.value);
                xmlHttpRequest.send();

                xmlHttpRequest.onload = function () {
                    if (xmlHttpRequest.status === 200 || xmlHttpRequest === 201) {
                        alert("이메일이 등록되었습니다.");
                        window.location.href = "/subscribe";
                    }
                }
            }
        )
    }
}
listener.init();