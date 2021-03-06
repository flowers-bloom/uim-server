package io.github.flowersbloom.packet;

import com.alibaba.fastjson.JSON;
import io.github.flowersbloom.command.BizCommand;
import io.github.flowersbloom.udp.entity.User;
import io.github.flowersbloom.udp.packet.BasePacket;
import io.netty.buffer.ByteBuf;
import lombok.Data;

import java.util.List;

@Data
public class ActiveDataPacket extends BasePacket {
    List<User> activeList;

    public ActiveDataPacket() {
        this.command = BizCommand.ACTIVE_DATA_PACKET;
    }

    @Override
    public ByteBuf toNewBuf(long serialNumber) {
        ByteBuf byteBuf = super.toNewBuf(serialNumber);
        String json = JSON.toJSONString(this);
        byteBuf.writeBytes(json.getBytes());
        return byteBuf;
    }
}
