package io.github.flowersbloom.packet;

import com.alibaba.fastjson.JSON;
import io.github.flowersbloom.command.BizCommand;
import io.github.flowersbloom.udp.packet.BasePacket;
import io.netty.buffer.ByteBuf;
import lombok.Data;

/**
 * 广播报文
 */
@Data
public class BroadcastDataPacket extends BasePacket {
    String senderId;
    String content;

    public BroadcastDataPacket() {
        this.command = BizCommand.BROADCAST_DATA_PACKET;
    }

    @Override
    public ByteBuf toNewBuf(long serialNumber) {
        ByteBuf byteBuf = super.toNewBuf(serialNumber);
        byteBuf.writeBytes(JSON.toJSONString(this).getBytes());
        return byteBuf;
    }
}
