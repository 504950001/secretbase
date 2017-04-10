package top.zemal.service;

import org.springframework.stereotype.Service;
import top.zemal.dao.PermissionRepository;
import top.zemal.model.Permission;
import top.zemal.service.BaseService;

/**
 * @author zemal-tan
 * @description
 * @create 2017-04-10 18:28
 **/
@Service
public class PermissionService extends BaseService<Permission, PermissionRepository> {
}
