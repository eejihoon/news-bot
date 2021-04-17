const listener = {
    init: function () {
        const _this = this;
        document.querySelector("#btn-subscribe").addEventListener("click", (e) => {
                e.preventDefault();
                _this.subscribe();
            }
        )

        document.querySelector("#btn-cancel-subscribe").addEventListener("click", (e) => {
            e.preventDefault();
            _this.cancelSubscribe();
        })
    },

    subscribe: function () {
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
    },
    cancelSubscribe : function () {
        const email = document.querySelector("#cancelEmail");
        const xmlHttpRequest = new XMLHttpRequest();
        xmlHttpRequest.open('DELETE', '/api/subscribe');
        xmlHttpRequest.setRequestHeader("Content-Type", "application/json");
        xmlHttpRequest.send(JSON.stringify(email.value));

        xmlHttpRequest.onload = function () {
            if (xmlHttpRequest.status === 200) {
                alert('구독 취소되었습니다.');
                window.location.href = '/subscribe';
            } else {
                alert('잘못된 이메일입니다.');
            }
        }

    }
}
listener.init();