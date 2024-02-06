(function () {
    "use strict";

    // 화면 최초 접속 시 동작될 작업
    document.addEventListener('DOMContentLoaded', () => {
        document.querySelector('#tableDetail').classList.add('d-none')
    })

    // JS 파일로 제외한 뒤 defer 속성 사용 시 DOMContentLoaded 에 안넣고 바로 사용 가능
    /* searchForm 예제 Start */
    btnSelect.onclick = (e) => {
        const formData = serializeObject(searchForm)
        console.log("formData", formData)
        console.table(formData)
        console.log("jsonData", JSON.stringify(formData, null, 2))
    }
    /* searchForm 예제 End */

    /* table 예제 Start -> 공통으로 처리 예정 */
    document.querySelector('#tableMain tbody').addEventListener('click', () => {
        showTableDetail()
    })

    document.querySelector('#searchForm').addEventListener('click', () => {
        hideTableDetail()
    })

    const buttons = document.querySelectorAll('#tableMain tbody tr')
    for (const button of buttons) {
        button.onclick = (e) => {
            buttons.forEach((ele, idx) => {
                ele.classList.remove('table-active')
            })

            let $tr = e.currentTarget
            let $td = $tr.childNodes

            // if($tr.classList.contains('.datatable-empty')) {
            if($tr.querySelector('.datatable-empty')) {
                return
            }

            $tr.classList.add('table-active')
            $td.forEach((ele, idx) => {
                let $detail = document.querySelectorAll('#tableDetail [id]')
                $detail[idx].value = ele.innerText

                let label = $detail[idx].parentNode.querySelector("label").innerText
                let $valid = $detail[idx].parentNode.querySelector(".invalid-feedback")
                if($valid) {
                    $valid.innerText = `Please provide a valid ${label}`
                }
            })
        }
    }
    /* table 예제 End */

    /* modal 예제 Start */
    // document.querySelector('#btnModal').addEventListener('click', () => {
    btnModal.addEventListener('click', (e) => {
        // this 가 window 로만 먹어서 e 로 처리 -> 추후 확인
        // e.target = 클릭한 위치(span) / e.currentTarget = 이벤트 위치(button)
        const modalId = e.currentTarget.dataset.bsTarget
        console.log(modalId)
        console.log(document.querySelector(modalId))

        // var modal = bootstrap.Modal.getOrCreateInstance(document.querySelector('#modalPopup'))
        var modal = bootstrap.Modal.getOrCreateInstance(modalPopup)
        // modal.show()
        // modal.hide()
    })
    /* modal 예제 End */

    const showTableDetail = () => {
        if(tableMain.querySelector('.datatable-empty')) {
            return
        }

        tableDetail.classList.remove('d-none')
        tableMain.classList.replace('col-lg-12', 'col-lg-8')

        document.querySelector('#tableDetail form').classList.remove('was-validated')
    }

    const hideTableDetail = () => {
        tableDetail.classList.add('d-none')
        tableMain.classList.replace('col-lg-8', 'col-lg-12')
    }

    const toggleTableDetail = () => {
        if(!tableDetail.classList.contains('d-none')) {
            hideTableDetail()
            return
        }
        showTableDetail()
    }

    const serializeObject = (form) => {
        const formData = new FormData(form);
        let serializedData = {};

        for (var [name, value] of formData) {
            if (serializedData[name]) {
                if (!Array.isArray(serializedData[name])) {
                    serializedData[name] = [serializedData[name]];
                }
                serializedData[name].push(value);
            } else {
                serializedData[name] = value;
            }
        }

        return serializedData;
    }

})();