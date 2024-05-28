import request from '@/utils/request'

// 查询个人动态列表
export function listStatus(query) {
  return request({
    url: '/system/status/list',
    method: 'get',
    params: query
  })
}

// 查询个人动态详细
export function getStatus(id) {
  return request({
    url: '/system/status/' + id,
    method: 'get'
  })
}

// 新增个人动态
export function addStatus(data) {
  return request({
    url: '/system/status',
    method: 'post',
    data: data
  })
}

// 修改个人动态
export function updateStatus(data) {
  return request({
    url: '/system/status',
    method: 'put',
    data: data
  })
}

// 删除个人动态
export function delStatus(id) {
  return request({
    url: '/system/status/' + id,
    method: 'delete'
  })
}
