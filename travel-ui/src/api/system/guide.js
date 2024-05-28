import request from '@/utils/request'

// 查询旅游攻略信息列表
export function listGuide(query) {
  return request({
    url: '/system/guide/list',
    method: 'get',
    params: query
  })
}

// 查询旅游攻略信息详细
export function getGuide(id) {
  return request({
    url: '/system/guide/' + id,
    method: 'get'
  })
}

// 新增旅游攻略信息
export function addGuide(data) {
  return request({
    url: '/system/guide',
    method: 'post',
    data: data
  })
}

// 修改旅游攻略信息
export function updateGuide(data) {
  return request({
    url: '/system/guide',
    method: 'put',
    data: data
  })
}

// 删除旅游攻略信息
export function delGuide(id) {
  return request({
    url: '/system/guide/' + id,
    method: 'delete'
  })
}
