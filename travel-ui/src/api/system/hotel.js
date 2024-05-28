import request from '@/utils/request'

// 查询酒店信息列表
export function listHotel(query) {
  return request({
    url: '/system/hotel/list',
    method: 'get',
    params: query
  })
}

// 查询酒店信息详细
export function getHotel(id) {
  return request({
    url: '/system/hotel/' + id,
    method: 'get'
  })
}

// 新增酒店信息
export function addHotel(data) {
  return request({
    url: '/system/hotel',
    method: 'post',
    data: data
  })
}

// 修改酒店信息
export function updateHotel(data) {
  return request({
    url: '/system/hotel',
    method: 'put',
    data: data
  })
}

// 删除酒店信息
export function delHotel(id) {
  return request({
    url: '/system/hotel/' + id,
    method: 'delete'
  })
}
