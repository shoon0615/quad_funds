"use strict"

/**
 *
 * @return void
 */
const initGrid = (tableId) => {
    /* 그리드 객체 */
    const Grid = tui.Grid

    Grid.applyTheme('striped')

    const sampleGrid = new Grid({
        el: document.getElementById(tableId),
        result: true,       // success
        data: {
            contentType: 'application/json',
            api: {
                readData: {
                    url: 'https://jsonplaceholder.typicode.com/posts/1/comments',
                    method: 'GET',
                },
                /*readData: { url: '/api/readData', method: 'GET', initParams: { param: 'param' } },
                createData: { url: '/api/createData', method: 'POST' },
                updateData: { url: '/api/updateData', method: 'PUT' },
                modifyData: { url: '/api/modifyData', method: 'PUT' },
                deleteData: { url: '/api/deleteData', method: 'DELETE' },*/
            },
            /* [serializer] ajax 용 param 직렬화 */
            /*serializer(params) {
                // return Qs.stringify(params)
                return JSON.stringify(params)
            },*/
            /* [contents] 샘플 데이터 */
            // contents: [],
            /* [hideLoadingBar] 로딩바 숨기기 옵션(default: false) */
            // hideLoadingBar: true
        },
        /*result: false,    // error
        message: "Error message from the server",*/
        pageOptions: {
            perPage: 3,
            /* [useClient] 페이징 처리 -> true: front 에서 페이징, false: server 에서 페이징 */
            // useClient: true,
            totalCount: 10
        },
        rowHeaders: ['rowNum'],
        columns: [
            {
                header: '1번 컬럼(postId)',
                name: 'postId'
            },
            {
                header: '2번 컬럼(id)',
                name: 'id'
            },
            {
                header: '3번 컬럼(name)',
                name: 'name'
            },
            {
                header: '4번 컬럼(email)',
                name: 'email'
            },
            {
                header: '5번 컬럼(body)',
                name: 'body'
            },
        ]
    })
    return sampleGrid
}