given
一个聪明的停车小弟，他负责两个停车场，第一个停车场有2个空车位，第二个停车场有1个空车位
when
聪明的小弟停车
then
停车成功，车被停在第一个停车场了，返回一个能够取出这辆车的票

given
一个聪明的停车小弟，他负责两个停车场，第一个停车场有1个空车位，第二个停车场有2个空车位
when
聪明的小弟停车
then
停车成功，车被停在第二个停车场了，返回一个能够取出这辆车的票


given
一个聪明的停车小弟，他负责两个停车场，第一个停车场有1个空车位，第二个停车场有1个空车位
when
聪明的小弟停车
then
停车成功，车被停在第一个停车场了，返回一个能够取出这辆车的票


Given
一个聪明的停车小弟，和他负责的停车场，还有一辆要停的车，但是所有停车场都停满了
when
聪明的停车小弟要停车
then
停车失败

Given
一个聪明的停车小弟，和他负责的停车场，还有一张能够取车的票，这张票对应的车在第一个停车场
when
聪明的停车小弟要取车
then
正确地取到了原车

Given
一个聪明的停车小弟，和他负责的停车场，还有一辆能够取车的票，这张票对应的车在第二个停车场
when
聪明的停车小弟要取车
then
正确地取到了原车

Given
一个聪明的停车小弟，和他负责的停车场，还有一辆无法取车的票，这张票不对应所有停车场里的车
when
聪明的停车小弟要取车
then
取车失败，

Given
一个聪明的停车小弟，和他负责的停车场，还有一张已经被用来取到了车的票
when
聪明的停车小弟要取车
then
取车失败
