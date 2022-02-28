alter table t_receipt_flow add column up_inventory_same_location tinyint(4) not null default 0 comment '同库位上架，0-否，1-是';

alter table t_receipt_220 add column `up_on_same_location` tinyint(4) not null default '0' comment '同库位上架标识，0-否，1-b2b快速上架，2-原快速上架';

alter table t_receipt_220 add column `related_order_code` varchar(50) NOT NULL DEFAULT '' COMMENT '[关联单号]';

alter TABLE t_receipt_220 add INDEX `idx_wr` (`warehouse_code`,`related_order_code`);