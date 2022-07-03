update t_entry_order_detail_040 set up_qty = 1 WHERE entry_order_detail_id = '850451902668292096';
update t_entry_order_detail_040 set wait_up_qty = 0, up_qty = 1 where entry_order_detail_id = '850451902957699072';

update  t_inventory_040 set stock_qty = 0 where inventory_id = '852630144937967616';

insert into  t_inventory_040 (inventory_id,item_code,barcode,owner_code,warehouse_code,location_code,zone_code,stock_qty,locked_qty,frozen_qty,intransit_qty,available_qty,inventory_type,broken_grade,batch,manufacture_date,expiration_date,last_inventory_count_time,trans_qty,wait_qty,version,knit_qty,product_batch_manage)
values('854356302406184960','GS202106091751','4061617705678','CS0242','WH0063','4L-14-07','4L',1,0,0,0,1,'ZP','','CGRK202106102578720210615','1971-01-01','1971-01-01','1971-01-01 00:00:00',0,0,0,0,'');
