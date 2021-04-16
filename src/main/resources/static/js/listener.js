const listener = {
    init: () => {
        document.querySelector("#btn-subscribe").addEventListener("click", (e) => {
                e.preventDefault();
                const email = document.querySelector("#emailAddress").value;
                const xmlHttpRequest = new XMLHttpRequest();
                xmlHttpRequest.open('POST', '/api/subscribe');
                xmlHttpRequest.setRequestHeader("Content-Type", "application/json");
                xmlHttpRequest.send(JSON.stringify(email));

                xmlHttpRequest.onload = function () {
                    if (xmlHttpRequest.status === 200 || xmlHttpRequest === 201) {
                        alert("이메일이 등록되었습니다.");
                        window.location.href = "/subscribe";
                    } else if (xmlHttpRequest.status === 400) {
                        alert("잘못된 이메일입니다.");
                    } else if (xmlHttpRequest.status === 409) {
                        alert('이미 등록된 이메일입니다.');
                    }
                }
            }
        )
    }
}
listener.init();