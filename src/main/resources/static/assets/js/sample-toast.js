"use strict"

/**
 *
 * @return void
 */
const initGrid = (tableId) => {
    /* 그리드 객체 */
    const Grid = tui.Grid

    /**
     * Grid 테마 커스텀
     * Grid.applyTheme('striped', {...}) :
     * @param {String} default : 프리셋 (기본)
     * @param {String} striped : 프리셋 (줄무늬)
     * @param {String} clean : 프리셋 (클린)
     *      - preset theme name. Available values are 'default', 'striped' and 'clean'.
     *      - https://nhn.github.io/tui.grid/latest/Grid#applyTheme
     */
    Grid.applyTheme('striped')
    /*Grid.applyTheme('defualt',  {
        cell: {
            normal: {
                border: 'black'
            },
            header: {
                background: 'gray',
                text: 'white'
            },
            evenRow: {
                background: '#fee'
            }
        }
    })*/

    /**
     * 그리드 설정
     * @variable {Dom} el : 그리드 element(DOM)
     * @variable {boolean} scrollX : X 스크롤 사용여부
     * @variable {boolean} scrollY : Y 스크롤 사용여부
     * @variable {boolean} draggable : 드레그 사용 여부
     * @variable {Object} header
     *      - @variable {Number} height : 헤더 높이
     * @variable {Number} bodyHeight : 그리드 바디 높이
     * @variable {*} contextMenu : 마우스 우클릭 옵션
     * @variable {Array} columns :
     *      - @variable {String} header : 컬럼명(헤더)
     *      - @variable {String} name : 컬럼 name (input data와 이름이 일치해야함)
     *      - @variable {String} align : 정렬
     *      - @variable {Number} width : 너비
     *      - @variable {String} whiteSpace : 줄바꿈 설정
     *      - @variable {Function} formatter : 출력 포멧
     * 기타 옵션은 공식 document 참조
     */
    const sampleGrid = new Grid({
        el: document.getElementById(tableId),
        scrollX: true,
        scrollY: true,
        draggable: false,
        header: { height: 30 },
        bodyHeight: 200,
        contextMenu: null,
        rowHeaders: [{
            type: 'rowNum',
            header: '순번',
            width: 50,
        }],
        columns: [
            // [Column-1] 사용자 아이디
            {
                header: '사용자 아이디',            // [필수] 컬럼 이름
                name: 'userId',                 // [필수] 컬럼 매핑 이름 값
                sortable: true,                 // [선택] 컬럼의 정렬 여부
                resizable: true,                // [선택] 컬럼의 리사이즈 여부 옵션
                editor: 'text',                 // [선택] 수정 옵션
                // [선택] 필터 옵션
                filter: {
                    type: 'text',
                    showApplyBtn: true,
                    showClearBtn: true
                },
                ////^[a-z|A-Z]*$/
                // [선택] 유효성 검증 옵션
                validation: {
                    required: true,
                    dataType: 'string',
                    regExp: /^[a-z|A-Z||0-9 ]*$/, //    [정규식] 영문 숫자에 대한 조합만 가능
                },
            },
            // [Column-2] 사용자 이름
            {
                header: '사용자 이름',             // [필수] 컬럼 이름
                name: 'userNm',                 // [필수] 컬럼 매핑 이름 값
                sortable: true,                 // [선택] 컬럼의 정렬 여부
                resizable: true,                // [선택] 컬럼의 리사이즈 여부 옵션
                editor: 'text',                 // [선택] 수정 옵션
                // [선택] 필터 옵션
                filter: {
                    type: 'text',
                    showApplyBtn: true,
                    showClearBtn: true
                },
                // [선택] 유효성 검증 옵션
                validation: {
                    required: true,
                    dataType: 'string',
                    regExp: /^[a-z|A-Z|ㄱ-ㅎ|가-힣|0-9 ]*$/, // [정규식] 특수문자를 제외한 공백포함 사용 가능
                },
            },
            // [Column-3] 사용자 이메일
            {
                header: '사용자 이메일',            // [필수] 컬럼 이름
                name: 'userMail',               // [필수] 컬럼 매핑 이름 값
                sortable: true,                 // [선택] 컬럼의 정렬 여부
                resizable: true,                // [선택] 컬럼의 리사이즈 여부 옵션
                editor: 'text',                 // [선택] 수정 옵션
                // [선택] 필터 옵션
                filter: {
                    type: 'text',
                    showApplyBtn: true,
                    showClearBtn: true
                },
                // [선택] 유효성 검증 옵션
                validation: {
                    unique: true,               // [선택] 유일성 체크 확인 옵션
                    required: true,
                    dataType: 'string',
                    regExp: /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i
                },
            },


            // [Column-4] 사용자 나이
            {
                header: '사용자 나이',            // [필수] 컬럼 이름
                name: 'userAge',               // [필수] 컬럼 매핑 이름 값
                sortable: true,                // [선택] 컬럼의 정렬 여부
                resizable: true,               // [선택] 컬럼의 리사이즈 여부 옵션
                editor: 'text',                // [선택] 수정 옵션
                align: 'center',               // [선택] 텍스트 정렬 옵션
                // [선택] 필터 옵션
                filter: {
                    type: 'text',
                    showApplyBtn: true,
                    showClearBtn: true
                },
                // [선택] 유효성 검증 옵션
                validation: {
                    unique: true,               // [선택] 유일성 체크 확인 옵션
                    dataType: 'number',         // [선택] 데이터 타입 체크 옵션
                    required: true,             // [선택] 필수 여부 체크 옵션
                    min: 1,                     // [선택] 최소값
                    max: 100,                   // [선택] 최대값
                }
            },
            // [Column-5] 사용 여부
            {
                header: '사용자 성별',             // [필수] 컬럼 이름
                name: 'userGender',             // [필수] 컬럼 매핑 이름 값
                sortable: true,                 // [선택] 컬럼의 정렬 여부
                resizable: true,                // [선택] 컬럼의 리사이즈 여부 옵션
                align: 'center',                // [선택] 텍스트 정렬 옵션
                filter: 'select',               // [선택] 필터 옵션
                formatter: 'listItemText',      // [선택] select box 옵션
                editor: {
                    type: 'radio',
                    options: {
                        listItems: [
                            {text: '남성', value: "man"},
                            {text: '여성', value: "woman"},
                        ]
                    },
                },
            },

            // [Column-5] 사용자 취미
            {
                header: '사용자 취미',            // [필수] 컬럼 이름
                name: 'userHobby',             // [필수] 컬럼 매핑 이름 값
                align: 'center',               // [선택] 텍스트 정렬 옵션
                sortable: true,                // [선택] 컬럼의 정렬 여부
                resizable: true,               // [선택] 컬럼의 리사이즈 여부 옵션
                formatter: 'listItemText',     // [선택] 값을 기반으로 select box 옵션
                // [Option] 필터 옵션
                filter: {
                    type: 'select',
                    showApplyBtn: true,
                    showClearBtn: true
                },
                // [Option] select 옵션
                editor: {
                    type: 'select',
                    options: {
                        listItems: [
                            {text: "독서", value: "H1"},
                            {text: "복싱", value: "H2"},
                            {text: "스킨스쿠버", value: "H3"},
                            {text: "탁구", value: "H4"},
                        ]
                    }
                },
            },
            // [Column-5] 사용자 시퀀스 - Hidden
            {
                header: '사용자 시퀀스',            // [필수] 컬럼 이름
                name: 'userSq',                 // [필수] 컬럼 매핑 이름 값
                hidden: true,                   // [선택] 숨김 여부
            },
            // [Column-6] 시작 일자 - Date
            {
                header: '시작 일자',               // [필수] 컬럼 이름
                name: 'startDate',              // [필수] 컬럼 매핑 이름 값
                editor: 'datePicker',           // [선택] 수정 옵션
            },
            // [Column-7] 종료 일자 - Date
            {
                header: '종료 일자',               // [필수] 컬럼 이름
                name: 'endDate',                // [필수] 컬럼 매핑 이름 값
                // [Option] datePicker 옵션
                editor: {
                    type: 'datePicker',
                    options: {
                        format: 'dd/MM/yyyy HH:mm A',
                        // timepicker: true,
                        timepicker: {
                            layoutType: 'tab',
                            inputType: 'spinbox'
                        },
                        selectableRanges: [[new Date(2022, 10, 15), new Date(2022, 12, 31)]],
                        /*format: 'yyyy-MM',
                        type: 'month',
                        format: 'yyyy',
                        type: 'year',*/
                    }
                }
            },
            // [Front - Sample]
            {
                header: '날짜',
                name: 'date',
                align: 'center',
                width: 150,
                whiteSpace: 'normal',
                formatter: function (e) {
                    return e.value
                },
            },
            {
                header: '이름',
                name: 'name',
                align: 'left',
                width: 100,
                whiteSpace: 'normal',
                formatter: function (e) {
                    return e.value
                },
            },
            {
                header: '위치',
                name: 'location',
                align: 'left',
                width: 150,
                whiteSpace: 'normal',
                formatter: function (e) {
                    return e.value
                },
            },
        ],
        data: [
            {
                "userId": "adjh54",
                "userNm": "Lee",
                "userMail": "adjh54@gmail.com",
                "userGender": "man",
                "userAge": 20,
                "userHobby": "H1",
                "userSq": 1,
                "startDate": "2022-12-01",
                "endDate": "04/12/2022 09:45 AM",
            },
            {
                "userId": "ckask123",
                "userNm": "jong",
                "userMail": "ckask@gmail.com",
                "userGender": "woman",
                "userAge": 22,
                "userHobby": "H3",
                "userSq": 2,
                "startDate": "2022-11-01",
                "endDate": "31/12/2022 11:00 PM",
            },
            {
                "userId": "hahahoho",
                "userNm": "ha",
                "userMail": "hahahoho@gmail.com",
                "userGender": "man",
                "userAge": 23,
                "userHobby": "H4",
                "userSq": 3,
                "startDate": "2022-11-01",
                "endDate": "30/11/2022 09:00 AM",
            },
        ]
    })
    return sampleGrid
}