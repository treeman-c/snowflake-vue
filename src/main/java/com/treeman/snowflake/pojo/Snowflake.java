package com.treeman.snowflake.pojo;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class Snowflake {

  /**
   * 方式一：JsonSerialize注解  解决数据前端只接受数字前16位而丢失后面数字的情况
   * 主键
   */
  @JsonSerialize(using = ToStringSerializer.class)
  private long id;
  private long timeBit;
  private long workBit;
  private long dataBit;
  private long sequence;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getTimeBit() {
    return timeBit;
  }

  public void setTimeBit(long timeBit) {
    this.timeBit = timeBit;
  }


  public long getWorkBit() {
    return workBit;
  }

  public void setWorkBit(long workBit) {
    this.workBit = workBit;
  }


  public long getDataBit() {
    return dataBit;
  }

  public void setDataBit(long dataBit) {
    this.dataBit = dataBit;
  }


  public long getSequence() {
    return sequence;
  }

  public void setSequence(long sequence) {
    this.sequence = sequence;
  }

  @Override
  public String toString() {
    return "Snowflake{" +
            "id=" + id +
            ", timeBit=" + timeBit +
            ", workBit=" + workBit +
            ", dataBit=" + dataBit +
            ", sequence=" + sequence +
            '}';
  }
}
