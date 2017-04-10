package top.zemal.service.baseservice;

import org.springframework.stereotype.Service;
import top.zemal.dao.UserRepository;
import top.zemal.model.User;
import top.zemal.service.BaseService;

import javax.jws.soap.SOAPBinding;

/**
 * @author zemal-tan
 * @description
 * @create 2017-04-10 18:01
 **/

@Service
public class UserBaseService extends BaseService<User, UserRepository> {
}
