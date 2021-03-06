package io.github.flowersbloom.udp.packet;

import com.alibaba.fastjson.JSON;
import io.github.flowersbloom.udp.Command;
import io.github.flowersbloom.udp.entity.User;
import io.netty.buffer.ByteBuf;
import lombok.Data;

/**
 * 心跳报文
 */
@Data
public class HeartbeatPacket extends BasePacket {
    User user;

    public HeartbeatPacket() {
        this.command = Command.HEARTBEAT_PACKET;
    }

    @Override
    public ByteBuf toNewBuf(long serialNumber) {
        ByteBuf byteBuf = super.toNewBuf(serialNumber);
        byteBuf.writeBytes(JSON.toJSONString(this).getBytes());
        return byteBuf;
    }
}
