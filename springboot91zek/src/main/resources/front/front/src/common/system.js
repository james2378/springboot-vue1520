export function isAuth(tableName, key) {
  let role = localStorage.getItem("UserTableName");
  let menus = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-qrcode","buttons":["新增","查看","修改","删除"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["新增","查看","修改","删除","审核"],"menu":"志愿者","menuJump":"列表","tableName":"zhiyuanzhe"}],"menu":"志愿者管理"},{"child":[{"appFrontIcon":"cuIcon-wenzi","buttons":["查看","修改","删除","审核"],"menu":"申请志愿者","menuJump":"列表","tableName":"shenqingzhiyuanzhe"}],"menu":"申请志愿者管理"},{"child":[{"appFrontIcon":"cuIcon-goodsnew","buttons":["查看","修改","删除","审核"],"menu":"活动信息","menuJump":"列表","tableName":"huodongxinxi"}],"menu":"活动信息管理"},{"child":[{"appFrontIcon":"cuIcon-taxi","buttons":["查看","修改","删除"],"menu":"活动报名","menuJump":"列表","tableName":"huodongbaoming"}],"menu":"活动报名管理"},{"child":[{"appFrontIcon":"cuIcon-send","buttons":["查看","修改","删除"],"menu":"取消报名","menuJump":"列表","tableName":"quxiaobaoming"}],"menu":"取消报名管理"},{"child":[{"appFrontIcon":"cuIcon-taxi","buttons":["查看","修改"],"menu":"关于我们","tableName":"aboutus"},{"appFrontIcon":"cuIcon-newshot","buttons":["查看","修改"],"menu":"系统简介","tableName":"systemintro"},{"appFrontIcon":"cuIcon-camera","buttons":["查看","修改"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"公益新闻","tableName":"news"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看","活动报名"],"menu":"活动信息列表","menuJump":"列表","tableName":"huodongxinxi"}],"menu":"活动信息模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-wenzi","buttons":["新增","查看","修改","删除"],"menu":"申请志愿者","menuJump":"列表","tableName":"shenqingzhiyuanzhe"}],"menu":"申请志愿者管理"},{"child":[{"appFrontIcon":"cuIcon-goodsnew","buttons":["新增","查看","修改","删除"],"menu":"活动信息","menuJump":"列表","tableName":"huodongxinxi"}],"menu":"活动信息管理"},{"child":[{"appFrontIcon":"cuIcon-taxi","buttons":["查看","审核","删除"],"menu":"活动报名","menuJump":"列表","tableName":"huodongbaoming"}],"menu":"活动报名管理"},{"child":[{"appFrontIcon":"cuIcon-send","buttons":["审核","查看","删除"],"menu":"取消报名","menuJump":"列表","tableName":"quxiaobaoming"}],"menu":"取消报名管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看","活动报名"],"menu":"活动信息列表","menuJump":"列表","tableName":"huodongxinxi"}],"menu":"活动信息模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-taxi","buttons":["查看","取消报名","删除"],"menu":"活动报名","menuJump":"列表","tableName":"huodongbaoming"}],"menu":"活动报名管理"},{"child":[{"appFrontIcon":"cuIcon-send","buttons":["查看","删除"],"menu":"取消报名","menuJump":"列表","tableName":"quxiaobaoming"}],"menu":"取消报名管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看","活动报名"],"menu":"活动信息列表","menuJump":"列表","tableName":"huodongxinxi"}],"menu":"活动信息模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"是","hasFrontRegister":"否","roleName":"志愿者","tableName":"zhiyuanzhe"}];
  for(let i=0;i<menus.length;i++){
    if(menus[i].tableName==role){
      for(let j=0;j<menus[i].frontMenu.length;j++){
          for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
            if(tableName==menus[i].frontMenu[j].child[k].tableName){
              let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
              return buttons.indexOf(key) !== -1 || false
            }
          }
      }
    }
  }
  return false;
}

/**
 *  * 获取当前时间（yyyy-MM-dd hh:mm:ss）
 *   */
export function getCurDateTime() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
    hour = currentTime.getHours(),
    minute = currentTime.getMinutes(),
    second = currentTime.getSeconds();
    return year + "-" + month + "-" + day + " " +hour +":" +minute+":"+second;
}

/**
 *  * 获取当前日期（yyyy-MM-dd）
 *   */
export function getCurDate() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
    return year + "-" + month + "-" + day;
}
