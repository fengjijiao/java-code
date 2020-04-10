package test;

import com.google.protobuf.InvalidProtocolBufferException;

public class test6 {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println("===== 构建一个Body模型开始 =====");
        PacketProto.Packet.Content packetContent_data = generateContentProto("W", "Q", "Hello, WQ!", 0);
        PacketProto.Packet.Body packetBody_data = generateBodyProto(1, "join", PacketProto.Packet.ContentType.TEXT, packetContent_data, System.currentTimeMillis());
        System.out.println(packetBody_data.toString());
        System.out.println("===== 构建Body模型结束 =====");

        System.out.println("===== Body Byte 开始=====");
        for (byte b : packetBody_data.toByteArray()) {
            System.out.print(b+" ");
        }
        System.out.println("\n" + "bytes长度" + packetBody_data.toByteString().size());
        System.out.println("===== Body Byte 结束 =====");

        System.out.println("===== 使用Body 反序列化生成对象开始 =====");
        PacketProto.Packet.Body gd = null;
        try {
            gd = PacketProto.Packet.Body.parseFrom(packetBody_data.toByteArray());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        System.out.print(gd.toString());
        System.out.println("===== 使用Body 反序列化生成对象结束 =====");
    }

    /*
    *生成消息内容
    * @params 目的ID, 来源ID, 内容, 标志
    * @result PacketProto.Packet.Content
     */
    private static PacketProto.Packet.Content generateContentProto(String toID, String fromID, String context, long flag) {
        PacketProto.Packet.Content.Builder packet_content_builder = PacketProto.Packet.Content.newBuilder();
        if(toID != null) packet_content_builder.setToID(toID);
        if(fromID != null) packet_content_builder.setFromID(fromID);
        if(context != null) packet_content_builder.setContext(context);
        if(flag != 0) packet_content_builder.setFlag(flag);
        return packet_content_builder.build();
    }

    /*
     *生成消息主体
     * @params 消息类型, 消息动作, 内容类型, PacketProto.Packet.Content(内容)， 时间戳
     * @result PacketProto.Packet.Body
     */
    private static PacketProto.Packet.Body generateBodyProto(int type, String action, PacketProto.Packet.ContentType contentType, PacketProto.Packet.Content content, long timestamp) {
        PacketProto.Packet.Body.Builder packet_body_builder = PacketProto.Packet.Body.newBuilder();
        if(type != 0) packet_body_builder.setType(type);
        if(action != null) packet_body_builder.setAction(action);
        if(contentType != null) packet_body_builder.setContentType(contentType);
        if(content != null) packet_body_builder.setContent(content);
        if(timestamp != 0) packet_body_builder.setTimestamp(timestamp);
        return packet_body_builder.build();
    }
}
